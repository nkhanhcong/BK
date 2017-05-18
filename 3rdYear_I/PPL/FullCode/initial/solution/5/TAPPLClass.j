.source TAPPLClass.java
.class public TAPPLClass
.super java.lang.Object

.method public static main([Ljava/lang/String;)V
.var 0 is args [Ljava/lang/String; from Label0 to Label1
.var 1 is x F from Label0 to Label1
.var 2 is y I from Label0 to Label1
Label0:
	iconst_3
	istore_2
	iload_2
	iconst_2
	iadd
	iconst_3
	iadd
	iconst_4
	swap
	i2f
	swap
	i2f
	fdiv
	fstore_1
	fload_1
	invokestatic io/writeFloat(F)V
Label1:
	return
.limit stack 2
.limit locals 3
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
