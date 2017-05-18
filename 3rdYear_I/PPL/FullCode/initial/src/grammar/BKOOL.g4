/**
 * Student name: Nguyen Khanh Cong
 * Student ID: 1410407
 */
grammar BKOOL;

@lexer::header{
  package bkool.parser;
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
BOOLEAN     : 'boolean'    ;
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

BOOLEANLIT  :('true'|'false');
FLOATLIT    :[0-9]+((('E'|'e')('+'|'-')?[0-9]+)|(('.'([0-9]*(('E'|'e')?|('E'|'e')('+'|'-')?)[0-9]+)?))) ;
ID          : [a-zA-Z_]+[a-zA-Z_0-9]*;
STRINGLIT   :'"'('\\'('b'|'f'|'r'|'n'|'t'|'"'|'\\')|~('\b'|'\\'|'\"'|'\n'|'\f'|'\r'|'\t'))*'"';


PRIMITIVE_TYPE: INTEGER| FLOAT| BOOLEAN|STRING| VOID;

type_notvoid        : INTEGER|FLOAT|BOOLEAN|STRING;


UNCLOSE_STRING: '"'('\\'('b'|'f'|'r'|'n'|'t'|'"'|'\\')|~('\b'|'\\'|'\"'|'\n'|'\f'|'\r'|'\t'))*;
ILLEGAL_ESCAPE: '"'([\u0020-\u007F]*?'\\'~('b'|'f'|'r'|'n'|'t'|'"'|'\\'));
ERROR_CHAR: ~[LSB RSB LP RP LB RB SEMICOLONE COLON DOT COMMA CONCAT GREATEREQUAL GREATER EQUAL MODULUS FLOAT_DIV SUB OBJECTCREAT NOT OR LESSEQUAL LESS NOTEQUAL IN_DIV MUL PLUS FORMFEED NEWLINE TAB];

// phase2

// class
// class
program             : classDecl+ EOF;
//class
classDecl           : 'class' ID ('extends' ID)? LP  member*  RP ;
// method
method_dec          :  element_type_method? STATIC? ID LB listPara RB block_stm;
listPara            : ((para SEMICOLONE)*para)?;
element_type_method :   (element_type|VOID);
//list
//list_mem            : member*;
//list_paras          : ((para SEMICOLONE)*para)?;
iden_list           : (ID COMMA)*ID;
list_expression     : ((expression COMMA)*expression)?;
brace_list_expression: LB list_expression RB;

//member of list
member               : constant_dec_global|variable_dec_global|method_dec;
decl                 : (constant_dec|variable_dec);
//member              : constant_dec|variable_dec|method_dec;
constant_dec_global    : STATIC? FINAL element_type ID '=' expression SEMICOLONE;
variable_dec_global    : STATIC? iden_list COLON element_type SEMICOLONE; //type may be primitive or array

    element_type    :  type_notvoid| array_type| class_type;
//immutable var
    constant_dec    : STATIC? FINAL element_type ID '=' expression SEMICOLONE;

    variable_dec    : STATIC? iden_list COLON element_type SEMICOLONE; //type may be primitive or array
para                : iden_list COLON element_type;
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
array_type          : typeArray LSB size RSB;
typeArray           : type_notvoid|ID;
size                : INTLIT;
class_type          : ID;

//expression
domain              : INTLIT| STRINGLIT| FLOATLIT| BOOLEANLIT|THIS|NIL|ID ;
expression          :     LB expression RB #braceExp
                                  // object creation
                       |  NEW expression (LB list_expression RB) #newExp
                                  //member access
                       |   expression DOT ID /*(LB list_expression RB)?*/ brace_list_expression? #callExp
                       |   expression LSB expression RSB #indexExp
                       |   (PLUS|SUB)expression #unaryPSOp
                       |   NOT expression #unaryNOp
                       |   expression CONCAT expression #binaryCOp
                       |    expression (MUL|FLOAT_DIV|IN_DIV|MODULUS) expression #binaryMFIMOp
                       |  expression (PLUS|SUB) expression #binaryPSOp
                       |   expression (AND|OR) expression #binaryAOOp
                       |   expression (EQUAL|NOTEQUAL) expression #binaryEQOp// relational expression
                       |   expression (GREATER|GREATEREQUAL|LESS|LESSEQUAL) expression #binaryGLOp // relational expression

                       |  domain #end
                         ;
// expNew                :  NEW expression (LB list_expression RB);
// expDot                :  expression DOT ID (LB list_expression RB)?;
// statement
block_stm           : LP decl*(statement)* RP;

asignment_statement : lhs ASSIGN expression SEMICOLONE;
lhs                 : ID
                    | expression DOT ID
                    | expression LSB expression RSB;
if_statement        : IF expression THEN (statement) (ELSE (statement))?;

for_statement       :  FOR scalar_variable ASSIGN expression ('to'| DOWNTO) expression DO (statement);
scalar_variable     : ID;
break_statement     : BREAK SEMICOLONE;
continue_statement  : CONTINUE SEMICOLONE;
return_statement    : RETURN expression SEMICOLONE;
method_inovation    : expression DOT ID (LB list_expression RB)? SEMICOLONE;




