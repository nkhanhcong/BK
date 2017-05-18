.source Utils.java
.class public Utils
.super java.lang.Object

.method public add(II)I
.var 0 is this LUtils; from Label0 to Label1
.var 1 is x I from Label0 to Label1
.var 2 is y I from Label0 to Label1
Label0:
	iload_1
	iload_2
	iadd
	ireturn
Label1:
.limit stack 2
.limit locals 3
.end method

.method public <init>()V
.var 0 is this LUtils; from Label0 to Label1
Label0:
	aload_0
	invokespecial java/lang/Object/<init>()V
Label1:
	return
.limit stack 1
.limit locals 1
.end method
