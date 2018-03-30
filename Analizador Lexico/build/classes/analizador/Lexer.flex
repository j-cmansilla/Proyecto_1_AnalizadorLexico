package analizador;
import static analizador.Token.*;
%%
%class Lexer
%type Token
L = [a-zA-Z_]
D = [0-9]
PalabraReservada = "abstract"|"as"|"break"|"case"|"catch"|"class"|"clone"|"const"|"continue"|"declare"|"default"|"die"|"do"|"echo"|"else"|"elseif"|"enddeclare"|"endfor"|"endforeach"|"endif"|"empty"|"endswitch"|"endwhile"|"eval"|"exit"|"extends"|"final"|"finally"|"for"|"foreach"|"function"|"if"|"implements"|"include"|"global"|"goto"|"include_once"|"instanceof"|"insteadof"|"interface"|"isset"|"new"|"print"|"list"|"namespace"|"private"|"protected"|"public"|"require"|"require_once"|"return"|"static"|"switch"|"throw"|"trait"|"try"|"unset"|"use"|"var"|"while"|"yield" 
operadoresA = "+"|"-"|"*"|"/"|"**"
operadoresL = "and"|"or"|"xor"|"!"|"&&"|"||"
tipoDeDato = "String"|"string"|"Int"|"int"|"Float"|"float"|"true"|"True"|"False"|"false"
WHITE=[ \t\r\n]
definicion = {L} {L}* ({D}* {L}*)* {WHITE}* "=" {WHITE}*
variable = "$" {definicion}
valoresValidos = "'" {WHITE}* {L} {L}* ({WHITE}* {L}*)* {WHITE}* "'" {WHITE}* ";" | {D} {D}* {WHITE}* ";"
definicionVariable = {variable} {valoresValidos}
constante = "const" {WHITE}* {definicion}
definicionConstante = {constante} {valoresValidos}

inicioPhp = "<?php"
cierrePhp = "?>"

sintaxis = {inicioPhp} {WHITE}* ({definicionVariable}* {WHITE}* {definicionConstante}*)* {WHITE}* {cierrePhp}


%{
public String lexeme;
%}
%%
{definicionVariable} {return VARIABLE;}
{definicionConstante} {return CONSTANTE;}
{sintaxis} {return CORRECTO;}
{tipoDeDato} {return TIPODEDATO;}
{PalabraReservada} {return PALABRARESERVADA;}
{operadoresA} {return OPERADORARITMETICO;}
{operadoresL} {return OPERADORLOGICO;}
{WHITE} {/*ignore*/}
. {return ERROR;}