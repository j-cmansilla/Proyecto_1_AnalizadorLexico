package analizador;
import static analizador.Token.*;
%%
%class Lexer
%line
%ignorecase
%type Token
PalabraReservada = "abstract"|"as"|"break"|"case"|"catch"|"class"|"clone"|"const"|"continue"|"declare"|"default"|"die"|"do"|"echo"|"enddeclare"|"eval"|"exit"|"extends"|"final"|"finally"|"function"|"implements"|"include"|"global"|"goto"|"include_once"|"instanceof"|"insteadof"|"interface"|"isset"|"new"|"print"|"list"|"namespace"|"private"|"protected"|"public"|"require"|"require_once"|"return"|"static"|"throw"|"trait"|"try"|"unset"|"use"|"var"|"while"|"yield" 
operadoresA = "+"|"-"|"*"|"/"|"**"|"%"|"++"|"--"
operadoresL = "and"|"or"|"xor"|"!"|"&&"|"||"|"not"
cadena = "String"|"string"
entero = "int"
texto = "'" ({Espacio}* {L}* {D}*)* {Espacio}* "'"
real = "float"|"double"
tipoDeDatoL = "true"|"True"|"False"|"false"
puntoYcoma = ";"
variable = "$"
inicio = "<?php"
fin = "?>"
llavea = "{"
llavec = "}"
asignacion = "="
comparacion = "=="
Espacio = [ ]
comentario = "//" ({Espacio}* {L}* {D}*)* {Espacio}*
comentarioMult = "/*" ({WHITE}* {L}* {D}*)* {WHITE}* "*/"
comilla = '
diferente = "!="
WHITE=[ \t\r\n]
L = [a-zA-Z_]
D = [0-9]
%{
public String lexeme;
public int linea;
%}
%%

{comentario} {lexeme=yytext(); return COMMENT;}
{comentarioMult} {lexeme=yytext(); return COMMENTM;}
"if" {lexeme=yytext(); return SI;}
"(" {lexeme=yytext(); return PAA;}
")" {lexeme=yytext(); return PAC;}
{texto} {lexeme=yytext(); return TEXTO;}
{WHITE} {/*Ignore*/}
{PalabraReservada} {lexeme=yytext(); return PALABRARESERVADA;}
{operadoresA} {lexeme=yytext(); return OPERADORARITMETICO;}
{operadoresL} {lexeme=yytext(); return OPERADORLOGICO;}
{cadena} {lexeme=yytext(); return CADENA;}
{comilla} {lexeme=yytext(); return COMILLA;}
{entero} {lexeme=yytext(); return ENT;}
{real} {lexeme=yytext(); return REA;}
{tipoDeDatoL} {lexeme=yytext(); return TIPODEDATOL;}
{inicio} {lexeme=yytext(); return INICIOPHP;}
{fin} {lexeme=yytext(); return FINPHP;}
{llavea} {lexeme=yytext(); return LLAVEA;}
{llavec} {lexeme=yytext(); return LLAVEC;}
{variable} {lexeme=yytext(); return VARIABLE;}
{asignacion} {lexeme=yytext(); return ASIGNACION;}
{comparacion} {lexeme=yytext(); return COMPARACION;}
{diferente} {lexeme=yytext(); return DIFERENTE;}
{puntoYcoma} {lexeme=yytext(); return PUNTOYCOMA;}
{L}({L}|{D})* {lexeme=yytext(); return ID;}
 ("(-"{D}+")")|{D}+ {lexeme=yytext(); return INT;}
. {lexeme=yytext();linea = yyline; return ERROR;}