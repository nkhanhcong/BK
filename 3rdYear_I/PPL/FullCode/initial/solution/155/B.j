.source B.java
.class public B
.super java.lang.Object

.method public static sum(II)I
.var 0 is a I from Label0 to Label1
.var 1 is b I from Label0 to Label1
.var 2 is e I from Label0 to Label1
Label0:
	iload_0
	iload_1
	iadd
	istore_2
	iload_2
	ireturn
Label1:
.limit stack 2
.limit locals 3
.end method

.method public <init>()V
.var 0 is this LB; from Label0 to Label1
Label0:
	aload_0
	invokespecial java/lang/Object/<init>()V
Label1:
	return
.limit stack 1
.limit locals 1
.end method
