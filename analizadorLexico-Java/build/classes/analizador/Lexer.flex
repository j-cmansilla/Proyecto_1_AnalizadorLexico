package analizador;
import static analizador.Token.*;
%%
%class Lexer
%line
%ignorecase
%type Token

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
Comment = {TraditionalComment} | {EndOfLineComment} | {DocumentationComment}
TraditionalComment   = "/*" [^*] ~"*/" | "/*" "*"+ "/"
EndOfLineComment     = "//" {InputCharacter}* {LineTerminator}?
DocumentationComment = "/**" {CommentContent} "*"+ "/"
CommentContent       = ( [^*] | \*+ [^/*] )*
PalabraReservada = "callable"|"null"|"abstract"|"as"|"case"|"catch"|"class"|"clone"|"declare"|"default"|"die"|"echo"|"enddeclare"|"eval"|"exit"|"extends"|"final"|"finally"|"implements"|"global"|"goto"|"include_once"|"instanceof"|"insteadof"|"interface"|"isset"|"new"|"print"|"list"|"namespace"|"private"|"protected"|"public"|"require"|"require_once"|"static"|"throw"|"trait"|"try"|"unset"|"use"|"var"|"yield"
constantesPredefinidas = "__LINE__"|"__FILE__"|"__DIR__"|"__FUNCTION__"|"__CLASS__"|"__TRAIT__"|"__METHOD__"|"__NAMESPACE__"
variablesPredefinidas = "$GLOBALS"|"$_SERVER"|"$_GET"|"$_POST"|"$_FILES"|"$_REQUEST"|"$_SESSION"|"$_ENV"|"$_COOKIE"|"$php_errormsg"|"$HTTP_RAW_POST_DATA"|"$http_response_header"|"$argc"|"$argv"
argumentoBD = "[" "`" ({Espacio}* {L}* {D}*)* {Espacio}*  "`" "]"
accesoBD = "$recordset"
operadoresA = "+"|"-"|"*"|"/"|"**"|"%"|"++"|"--"|"^"
operadoresL = "and"|"or"|"xor"|"!"|"&&"|"||"|"not"|"|"|"&"
identificador = ({L}|"_") ({L}|{D}|"_")*
real = "-"{D}{D}*"."{D}*|{D}{D}*"."{D}*
constante = "define" | "const"
/* "define" {Espacio}* "(" {texto} "," {texto} ")" | "const" {Espacio}* {identificador} | "define" {Espacio}* "(" {texto} "," {Espacio}* ({identificador}{Espacio}* "()") {Espacio}* ")"*/
variableError = "$" {D}({L}|{D}|"_")* | {D}({L}|{D}|"_")*
comillas = [\"]
especialChars = "*"|"-" | "/" | "_" | "." | "," | "~" | "!" | "@" | "#" | "$" | "%" | "'" | "^" | "&" | "|" | "(" | ")" |" {" | "}" | \"\" |"["|"]"|"<"|">"|"?"|"="|"+"|":"|";"|"'"
texto = "'" ({Espacio}* {L}* {especialChars}* {D}*)* {Espacio}* "'" | {comillas} ({Espacio}* {L}* {especialChars}* {D}*)* {Espacio}* {comillas}
tipoDeDatoL = "true"|"false"
Espacio = [ ]
comilla = '
WHITE=[ \t\r\n]
L = [a-zA-Z_]
D = [0-9]
%{
public String lexeme;
public int linea;
%}
%%

"\\" {lexeme=yytext(); return SLASH;}
{PalabraReservada} {lexeme=yytext(); return PALABRARESERVADA;}
{real} {{lexeme=yytext(); return REAL;}}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return INT;}
{accesoBD} {lexeme=yytext(); return ACCDB;}
{constantesPredefinidas} {lexeme=yytext(); return CONSTP;}
{constante} {lexeme=yytext(); return CONSTANTE;}
{variableError} {lexeme=yytext(); linea = yyline; return ERROR;}
{variablesPredefinidas} {lexeme=yytext(); return VARPRE;}
{argumentoBD} {lexeme=yytext(); return ARGBD;}
/*SIMBOLOS*/
"$" {lexeme=yytext(); return VARIABLE;}
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
{texto} {lexeme=yytext(); return TEXTO;}
{WHITE} {lexeme=yytext(); return ESPACIO;}
{operadoresA} {lexeme=yytext(); return OPERADORARITMETICO;}
{operadoresL} {lexeme=yytext(); return OPERADORLOGICO;}
"string" {lexeme=yytext(); return CADENA;}
{comilla} {lexeme=yytext(); return COMILLA;}
{comillas} {lexeme=yytext(); return COMILLA;}
"int" {lexeme=yytext(); return ENT;}
"float"|"double" {lexeme=yytext(); return REA;}
{tipoDeDatoL} {lexeme=yytext(); return TIPODEDATOL;}
{identificador} {lexeme=yytext(); return ID;}
{Comment} {lexeme=yytext(); return COMMENT;} 
. {lexeme=yytext();linea = yyline+1; return ERROR;}