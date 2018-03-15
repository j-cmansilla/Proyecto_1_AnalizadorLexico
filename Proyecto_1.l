%{

#include<stdio.h>
%}
palabrasReservadas abstract|as|break|case|catch|class|clone|const|continue|declare|default|die|do|echo|else|elseif|enddeclare|endfor|endforeach|endif|empty|endswitch|endwhile|eval|exit|extends|final|finally|for|foreach|function|if|implements|include|global|goto|include_once|instanceof|insteadof|interface|isset|new|print|list|namespace|private|protected|public|require|require_once|return|static|switch|throw|trait|try|unset|use|var|while|yield 
operadoresA [+]|[-]|[*]|[/]|[**]
operadoresL and|or|xor|!|&&|[||]
declaracionDeVariables [<][?]php[ \t]*[$][a-z]*[A-Z]*[ \t]*=[ \t]*'[a-z]*[A-Z]*'[ \t]*;[ \t]*[?][>]
tiposDeDato boolean|int|float|string|array|object|resource|callback|double
%%
{palabrasReservadas} {printf("PR\t");}
{operadoresA} {printf("OA\t");}
{operadoresL} {printf("OL\t");}
{tiposDeDato} {printf("TD\t");}
{declaracionDeVariables} {printf("variable\t");}
%%

int yywrap()
{
return 1;
}

main()
{
printf("Enter a string> \n");
yylex();
}