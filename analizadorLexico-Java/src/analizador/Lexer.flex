package analizador;
import static analizador.Token.*;
%%
%class Lexer
%line
%ignorecase
%type Token

/*Comentarios*/
LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
ErrorComment = "/*" {WHITE}* ({L}*{D}*)* {WHITE}*
Comment = {TraditionalComment} | {EndOfLineComment} | {DocumentationComment}
TraditionalComment   = "/*" [^*] ~"*/" | "/*" "*"+ "/"
EndOfLineComment     = "//" {InputCharacter}* {LineTerminator}?
DocumentationComment = "/**" {CommentContent} "*"+ "/"
CommentContent       = ( [^*] | \*+ [^/*] )*
AnotherComment = "#" ({Espacio}* {L}* {especialChars}* {D}*)*

/* EXPRESIONES REGULARES */

//Palabras reservadas, variables y constantes predefinidas
PalabraReservada = "empty"|"callable"|"null"|"abstract"|"as"|"case"|"catch"|"class"|"clone"|"declare"|"default"|"die"|"echo"|"enddeclare"|"eval"|"exit"|"extends"|"final"|"finally"|"implements"|"global"|"goto"|"include_once"|"instanceof"|"insteadof"|"interface"|"isset"|"new"|"print"|"list"|"namespace"|"private"|"protected"|"public"|"require"|"require_once"|"static"|"throw"|"trait"|"try"|"unset"|"use"|"var"|"yield"
constantesPredefinidas = "__LINE__"|"__FILE__"|"__DIR__"|"__FUNCTION__"|"__CLASS__"|"__TRAIT__"|"__METHOD__"|"__NAMESPACE__"
variablesPredefinidas = "$GLOBALS"|"$_SERVER"|"$_GET"|"$_FILES"|"$_REQUEST"|"$_SESSION"|"$_ENV"|"$_COOKIE"|"$php_errormsg"|"$HTTP_RAW_POST_DATA"|"$http_response_header"|"$argc"|"$argv"

//Acceso a la base de datos
argumentoBD = "[" "'" {Espacio}* {identificador} {Espacio}*  "'" "]"
ErrArgumentoBD = "[" "'" ({Espacio}* {L}* {especialChars}* {D}*)*  "'" "]"
accesoBD = "$recordset"

//Operadores lógicos y aritméticos
operadoresA = "+"|"-"|"*"|"/"|"**"|"%"|"++"|"--"|"^"
operadoresL = "and"|"or"|"xor"|"!"|"&&"|"||"|"not"|"|"|"&"

//Identificadores
identificador = ({L}|_) ({L}|{D}|_)* | "\$"({L}|_)({L}|{D}|_)*

//Numeros reales
real = "-"{D}{D}*"."{D}*|{D}{D}*"."{D}*

//Definición de constantes
constante = "define" | "const"

//Control de errores en variables
variableError = "$" {D}({L}|{D}|"_")* | {D}({L}|{D}|"_")*

//Comillas y textos
comillas = [\"]
especialChars = "*"|"-" | "/" | "_" | "." | "," | "~" | "!" | "@" | "#" | "$" | "%" | "'" | "^" | "&" | "|" | "(" | ")" |" {" | "}" | "\\" |"["|"]"|"<"|">"|"?"|"="|"+"|":"|";"|"'"
texto = "'" ({Espacio}* {L}* {especialChars}* {D}*)* {Espacio}* "'" | {comillas} ({Espacio}* {L}* {especialChars}* {D}*)* {Espacio}* {comillas}
comilla = '|`

//Tipo de dato lógicos
tipoDeDatoL = "true"|"false"

//Espacios en blanco, tabulaciones y saltos de línea
Espacio = [ ]
WHITE=[ \t\r\n]

//Letras y números
L = [a-zA-Z_]
D = [0-9]

%{
//Variables globales para ser accedidas después
public String lexeme;
public int linea;
%}
%%

/*PALABRAS RESERVADAS, VARIABLES Y CONSTANTES, TIPOS DE DATO Y ACCESO A LA BASE DE DATOS */
{PalabraReservada} {lexeme=yytext(); return PALABRARESERVADA;}
{real} {{lexeme=yytext(); return REAL;}}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return INT;}
{accesoBD} {lexeme=yytext(); return ACCDB;}
{constantesPredefinidas} {lexeme=yytext(); return CONSTP;}
{constante} {lexeme=yytext(); return CONSTANTE;}
{variablesPredefinidas} {lexeme=yytext(); return VARPRE;}
{argumentoBD} {lexeme=yytext(); return ARGBD;}
{ErrArgumentoBD} {lexeme=yytext(); return ERROR;}
{AnotherComment} {lexeme=yytext(); return COMMENT;}
{ErrorComment} {lexeme=yytext(); return ERROR;}
/* TEXTOS, ESPACIOS EN LAS LINEAS */
{texto} {lexeme=yytext(); return TEXTO;}
{WHITE} {lexeme=yytext(); return ESPACIO;}
"9pt" {lexeme=yytext(); return ESPACIO;}
//Error en las variables
{variableError} {lexeme=yytext(); linea = yyline; return ERROR;}

/*SIMBOLOS*/
"=!=" {lexeme=yytext(); return ERROR;}
"\\" {lexeme=yytext(); return SLASH;}
"if" {lexeme=yytext(); return SI;}
"(" {lexeme=yytext(); return PAA;}
"@" {lexeme=yytext(); return ARR;}
"?" {lexeme=yytext(); return SIGNIN;}
"return" {{lexeme=yytext(); return RET;}}
")" {lexeme=yytext(); return PAC;}
"else" {{lexeme=yytext(); return ELS;}}
"break" {{lexeme=yytext(); return BREA;}}
"while" {{lexeme=yytext(); return MIENTR;}}
"do" {{lexeme=yytext(); return HMIENTR;}}
"for" {{lexeme=yytext(); return PARA;}}
"bool"|"boolean" {{lexeme=yytext(); return BOOL;}}
"foreach" {{lexeme=yytext(); return PARAC;}}
"switch" {{lexeme=yytext(); return SELEC;}}
"include" {{lexeme=yytext(); return INCLUI;}}
"continue" {{lexeme=yytext(); return CONTIN;}}
"function" {{lexeme=yytext(); return FUN;}}
"<?php" {lexeme=yytext(); return INICIOPHP;}
"?>" {lexeme=yytext(); return FINPHP;}
"{" {lexeme=yytext(); return LLAVEA;}
"}" {lexeme=yytext(); return LLAVEC;}
"="|"=>"|"&="|".="|"/=" {lexeme=yytext(); return ASIGNACION;}
"==" {lexeme=yytext(); return COMPARACION;}
"!=" {lexeme=yytext(); return DIFERENTE;}
";" {lexeme=yytext(); return PUNTOYCOMA;}
"," {lexeme=yytext(); return COMA;}
"." {lexeme=yytext(); return PUNTO;}
"<" {lexeme=yytext(); return ETI;}
">" {lexeme=yytext(); return ETF;}
"[" {lexeme=yytext(); return PAI;}
"]" {lexeme=yytext(); return PAF;}
":" {lexeme=yytext(); return DOSPUNTOS;}

"string" {lexeme=yytext(); return CADENA;}
"int" {lexeme=yytext(); return ENT;}
"float"|"double" {lexeme=yytext(); return REA;}

/*OPERADORES ARITMETICOS Y LOGICOS*/
{operadoresA} {lexeme=yytext(); return OPERADORARITMETICO;}
{operadoresL} {lexeme=yytext(); return OPERADORLOGICO;}
/*COMILLAS*/
{comilla} {lexeme=yytext(); return COMILLA;}
{comillas} {lexeme=yytext(); return COMILLA;}

/*TIPOS DE DATO LOGICOS*/
{tipoDeDatoL} {lexeme=yytext(); return TIPODEDATOL;}

/*IDENTIFICADOR*/
{identificador} {lexeme=yytext(); return ID;}
"\$" {lexeme=yytext(); return ERROR;}
/*COMENTARIOS*/
{Comment} {lexeme=yytext(); return COMMENT;}

/*TOKEN NO RECONOCIDO*/
. {lexeme=yytext();linea = yyline; return ERROR;}
