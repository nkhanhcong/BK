;; Produced by JasminVisitor (BCEL)
;; http://bcel.sourceforge.net/
;; Sun Dec 11 06:15:44 ICT 2016

.source Input.java
.class  Input
.super java/lang/Object

.field final a I = 3
.field final t I = 9
.field final king Ljava/lang/String; = "kdk"

.method  <init>()V
.limit stack 2
.limit locals 1
.var 0 is this LInput; from Label0 to Label1

Label0:
.line 2
	aload_0
	invokespecial java/lang/Object/<init>()V
.line 3
	aload_0
	iconst_3
	putfield Input.a I
.line 4
	aload_0
	bipush 9
	putfield Input.t I
.line 6
	aload_0
	ldc "kdk"
	putfield Input.king Ljava/lang/String;
Label1:
	return

.end method

.method static main()V
.limit stack 0
.limit locals 0

.line 10
	return

.end method
