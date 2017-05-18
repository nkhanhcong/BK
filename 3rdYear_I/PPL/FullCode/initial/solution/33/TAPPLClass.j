.source TAPPLClass.java
.class public TAPPLClass
.super java.lang.Object

.method public static main([Ljava/lang/String;)V
.var 0 is args [Ljava/lang/String; from Label0 to Label1
.var 1 is a I from Label0 to Label1
.var 2 is b I from Label0 to Label1
.var 3 is c I from Label0 to Label1
Label0:
	iconst_3
	istore_1
	iconst_4
	istore_2
	iload_1
	iload_2
	imul
	iload_2
	iconst_2
	irem
	iadd
	istore_3
	iload_3
	invokestatic io/writeIntLn(I)V
Label1:
	return
.limit stack 3
.limit locals 4
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
