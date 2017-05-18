.source ass2.java
.class public ass2
.super io

.method public multi(I)I
.var 0 is this Lass2; from Label0 to Label1
.var 1 is n I from Label0 to Label1
Label0:
	iload_1
	bipush 10
	imul
	ireturn
Label1:
.limit stack 2
.limit locals 2
.end method

.method public <init>()V
.var 0 is this Lass2; from Label0 to Label1
Label0:
	aload_0
	invokespecial io/<init>()V
Label1:
	return
.limit stack 1
.limit locals 1
.end method
