/**
 * Define a grammar called Hello
 */
grammar MC;
options{
language=Java;
}
@lexer::header{
	package mc.parser;
}
@parser::header{
	package mc.parser;
}

program: assign+ ;

assign: ID ASSIGN exp SEMI;

exp: ID | INT | HEX | exp ADD exp ;

HEX: '0'[Xx][0-9A-Fa-f]+ ;

INT: [0-9]+;

ASSIGN: '=';

SEMI: ';';

ADD: [+-];

ID : [a-z]+ ;             // match lower-case identifiers

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines

