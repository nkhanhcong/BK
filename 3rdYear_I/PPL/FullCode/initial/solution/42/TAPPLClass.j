.source TAPPLClass.java
.class public TAPPLClass
.super java.lang.Object

.method public multi(I)I
.var 0 is this LTAPPLClass; from Label0 to Label1
.var 1 is n I from Label0 to Label1
Label0:
	iload_1
	bipush 30
	iadd
	ireturn
Label1:
.limit stack 2
.limit locals 2
.end method

.method public static main([Ljava/lang/String;)V
.var 0 is args [Ljava/lang/String; from Label0 to Label1
.var 1 is x I from Label0 to Label1
Label0:
	iconst_5
	iconst_4
	iadd
	iconst_3
	isub
	istore_1
	ldc "so cua ban in ra la "
	invokestatic io/writeStr(Ljava/lang/String;)V
	bipush 40
	invokestatic io/writeIntLn(I)V
Label1:
	return
.limit stack 2
.limit locals 2
.end method

.method public <init>()V
.var 0 is this LTAPPLClass; from Label0 to Label1
Label0:
	aload_0
	invokespecial java/lang/Object/<init>()V
Label1:
	return
.limit stack 1
.limit locals 1
.end method
