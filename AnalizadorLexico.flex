/* Sección de declaraciones de JFlex */
%%
%public
%class AnalizadorLexico
%{
 
 /* Código personalizado */
 
 // Se agregó una propiedad para verificar si existen tokens pendientes
 private boolean _existenTokens = false;
 
 public boolean existenTokens(){
 return this._existenTokens;
 }
 
%}
 
 /* Al utilizar esta instrucción, se le indica a JFlex que devuelva objetos del tipo TokenPersonalizado */
%type TokenPersonalizado
 
%init{
 /* Código que se ejecutará en el constructor de la clase */
%init}
 
%eof{
 
 /* Código a ejecutar al finalizar el análisis, en este caso cambiaremos el valor de una variable bandera */
 this._existenTokens = false;
 
%eof}
 
/* Inicio de Expresiones regulares */
 

 PalabraReservada = "and"|"abstract"|"as"|"break"|"case"|"catch"|"class"|"clone"|"const"|"continue"|"declare"|"default"|"die"|"do"|"echo"|"else"|"elseif"|"enddeclare"|"endfor"|"endforeach"|"endif"|"empty"|"endswitch"|"endwhile"|"eval"|"exit"|"extends"|"final"|"finally"|"for"|"foreach"|"function"|"if"|"implements"|"include"|"global"|"goto"|"include_once"|"instanceof"|"insteadof"|"interface"|"isset"|"new"|"print"|"list"|"namespace"|"private"|"protected"|"public"|"require"|"require_once"|"return"|"static"|"switch"|"throw"|"trait"|"try"|"unset"|"use"|"var"|"while"|"yield" 

 
/* Finaliza expresiones regulares */
 
%%
/* Finaliza la sección de declaraciones de JFlex */
 
/* Inicia sección de reglas */
 
// Cada regla está formada por una {expresión} espacio {código}
 


{PalabraReservada} {
 TokenPersonalizado t = new TokenPersonalizado(yytext(), "PALABRA RESERVADA");
 this._existenTokens = true;
 return t;
}


