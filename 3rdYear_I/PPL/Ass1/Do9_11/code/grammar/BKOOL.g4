/**
 * Student name : Nguyen Khanh Cong
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

//program  : 'class' ID LP RP EOF ;         // match keyword hello followed by an identifier


WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
BLANK: (' ');

TAB: ('\t');

FORMFEED: ('\f');

NEWLINE: ('\n');

CRETURN: ('\r');
//Comment
BLOCKCOMMENT: ('/*'[\u0000-\u00FE]*?('*/'|EOF))-> skip;
COMMENTLINE: '%%'(~([\r\n])*) -> skip;
COMMENT: COMMENTLINE|BLOCKCOMMENT ;



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
INTEGER     : 'int'     ;
NEW         : 'new'     ;
STRING      : 'string'  ;
THEN        : 'then'    ;
FOR         : 'for'     ;
RETURN      : 'return'  ;
VOID        : 'void'    ;
NIL         : 'nil'     ;
THIS        : 'this'    ;
FINAL       : 'final'   ;
DOWNTO      : 'downto'  ;


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
EQUAL       :'=='        ;
GREATER     :'>'        ;
AND         :'&&'       ;
GREATEREQUAL:'>='       ;
CONCAT      :'^'        ;
ASSIGN      :':='       ;

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

PRIMITIVE_TYPE: INTEGER| FLOAT| BOOLEAN|STRING| VOID;

type_notvoid        : INTEGER|FLOAT|BOOLEAN|STRING;


UNCLOSE_STRING: '"'('\\'('b'|'f'|'r'|'n'|'t'|'"'|'\\')|~('\b'|'\\'|'\"'|'\n'|'\f'|'\r'|'\t'))*;
ILLEGAL_ESCAPE: '"'([\u0020-\u007F]*?'\\'~('b'|'f'|'r'|'n'|'t'|'"'|'\\'));
ERROR_CHAR: ~[LSB RSB LP RP LB RB SEMICOLONE COLON DOT COMMA CONCAT GREATEREQUAL GREATER EQUAL MODULUS FLOAT_DIV SUB OBJECTCREAT NOT OR LESSEQUAL LESS NOTEQUAL IN_DIV MUL PLUS FORMFEED NEWLINE TAB];

// phase2

// class
// class
program             : class_dec+ EOF;
//class
class_dec           : 'class' ID ('extends' ID)? LP  list_mem  RP ;
// method
method_dec          : (element_type|VOID)? ('static')? ID LB list_paras RB block_stm;
//list
list_mem            : member*;
list_paras          : ((para SEMICOLONE)*para)?;
iden_list           : (ID COMMA)*ID;
list_expression     : ((expression COMMA)*expression)?;
list_statement      : (immutable| mutable)*(statement)*;
//member of list
member              : attribute|method_dec;
attribute           : mutable|immutable;
    immutable       : constant_dec;
    element_type    :  type_notvoid| array_type| class_type;
//immutable var
    constant_dec    : ('static')? FINAL element_type ID '=' expression SEMICOLONE;
//mutable var
    mutable         : variable_dec;
    variable_dec    : ('static')? iden_list ':' element_type SEMICOLONE; //type may be primitive or array
para                : iden_list ':' element_type;
statement           :      asignment_statement //statement
                   |   if_statement
                   |   for_statement
                   |   break_statement
                   |   continue_statement
                   |   return_statement
                   |   method_inovation
                   |   block_stm
                   ;

//Type
array_type          : (type_notvoid|ID) LSB size RSB;
size                : INTLIT;
class_type          : ID;

//expression
domain              : INTLIT| ID| STRINGLIT| FLOATLIT| BOOLEANLIT ;
expression          :     LB expression RB
                                  // object creation
                       |   NEW expression (LB list_expression RB)
                                  //member access
                       |   THIS DOT ID (LB list_expression RB)?
                       |   expression DOT ID (LB list_expression RB)?
                       |   expression LSB expression RSB //index expression
                       |   ('+'|'-')expression //airthmetic expression
                       |   NOT expression
                       |   expression CONCAT expression // string expression
                       |  expression (MUL|FLOAT_DIV|IN_DIV|MODULUS) expression //airthmetic expression
                       |  expression (PLUS|SUB) expression //airthmetic expression
                       |   expression (AND|OR) expression // boolean expression
                       |   expression (EQUAL|NOTEQUAL) expression // relational expression
                       |   expression (GREATER|GREATEREQUAL|LESS|LESSEQUAL) expression // relational expression
                       | NIL
                       | domain
                         ;
// statement
block_stm           : LP list_statement RP;
asignment_statement : lhs ASSIGN expression SEMICOLONE;
lhs                 : ID
                    | expression;
if_statement        : IF expression THEN (statement) (ELSE (statement))?;

for_statement       :  FOR scalar_variable ASSIGN expression ('to'| DOWNTO) expression DO (statement);
scalar_variable     : ID;
break_statement     : BREAK SEMICOLONE;
continue_statement  : CONTINUE SEMICOLONE;
return_statement    : RETURN expression SEMICOLONE;
method_inovation    : expression DOT ID (LB list_expression RB)? SEMICOLONE;




