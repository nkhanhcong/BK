/**
 * Student name : Nguyễn Khánh Công 
 * Student ID   :  1410407
 */
grammar BKOOL;

@lexer::header{
    package bkool.parser;
}

@lexer::members{
@Override
public Token emit() {
    switch (getType()) {
    case UNCLOSE_STRING:       
        Token result = super.emit();
        // you'll need to define this method
        throw new UncloseString(result.getText());
        
    case ILLEGAL_ESCAPE:
        result = super.emit();
        throw new IllegalEscape(result.getText());
    case ERROR_CHAR:
        result = super.emit();
        throw new ErrorToken(result.getText()); 
    default:
        return super.emit();
    }
}
}

@parser::header{
    package bkool.parser;
}

options{
    language=Java;
}

program  : 'class' ID LP RP EOF ;         // match keyword hello followed by an identifier


WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
BLANK: (' ');

TAB: ('\t');

FORMFEED: ('\f');

NEWLINE: ('\n');

CRETURN: ('\r');
//Comment
COMMENT: [COMMENTLINE BLOCKCOMMENT] ;
BLOCKCOMMENT: ('/*'[\u0000-\u007F]*?('*/'|EOF))-> skip;
COMMENTLINE: '%%'(~([\r\n])*) -> skip;


//Keyword
BOOLEAN     : 'bool'    ;
BREAK       : 'break'   ;
CLASS       : 'class'   ;
CONTINUE    : 'continue';
DO          : 'do'      ;
ELSE        : 'else'    ;
EXTENDS     : 'extends' ;
FLOAT       : 'float'   ;
IF          : 'if'      ;
INTEGER     : 'int' ;
NEW         : 'new'     ;
STRING      : 'string'  ;
THEN        : 'then'    ;
FOR         : 'for'     ;
RETURN      : 'return'  ;
VOID        : 'void'    ;
NIL         : 'nil'     ;
THIS        : 'this'    ;
FINAL       : 'final'   ;
STATIC      : 'static'  ;

//operator

PLUS        : '+'       ;
MUL         : '*'       ;
IN_DIV      : '\\'      ;
NOTEQUAL    : '!='      ;
LESS        : '<'       ;
LESSEQUAL   : '<='      ;
OR          : '||'      ;
NOT         : '!'       ;
OBJECTCREAT : 'new'     ;
SUB         :'-'        ;
FLOAT_DIV   :'/'        ;
MODULUS     :'%'        ;
EQUAL       :'=='       ;
GREATER     :'>'        ;
GREATEREQUAL:'>='       ;
CONCA       :'^'        ;

//separator

LSB         :'['        ;
RSB         :']'        ;
LP          :'{'        ;
RP          :'}'        ;
LB          :'('        ;
RB          :')'        ;
SEMICOLONE  :';'        ;
COLON       :':'        ;
DOT         :'.'        ;
COMMA       :','        ;


//Literal

INTLIT      :[0-9]+     ;


FLOATLIT    :[0-9]+((('E'|'e')('+'|'-')?[0-9]+)|(('.'([0-9]*(('E'|'e')?|('E'|'e')('+'|'-')?)[0-9]+)?))) ; 
ID          : [a-zA-Z_]+[a-zA-Z_0-9]*;
STRINGLIT   :'"'('\\'('b'|'f'|'r'|'n'|'t'|'"'|'\\')|~('\b'|'\\'|'\"'|'\n'|'\f'|'\r'|'\t'))*'"';
BOOLEANLIT  :('true'|'false');



UNCLOSE_STRING: '"'('\\'('b'|'f'|'r'|'n'|'t'|'"'|'\\')|~('\b'|'\\'|'\"'|'\n'|'\f'|'\r'|'\t'))*;
ILLEGAL_ESCAPE: '"'([\u0020-\u007F]*?'\\'~('b'|'f'|'r'|'n'|'t'|'"'|'\\'));
ERROR_CHAR: ~[LSB RSB LP RP LB RB SEMICOLONE COLON DOT COMMA CONCA GREATEREQUAL GREATER EQUAL MODULUS FLOAT_DIV SUB OBJECTCREAT NOT OR LESSEQUAL LESS NOTEQUAL IN_DIV MUL PLUS FORMFEED NEWLINE TAB];

