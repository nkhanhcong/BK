.source Shape.java
.class public Shape
.super java.lang.Object

.method public b(III)I
.var 0 is this LShape; from Label0 to Label1
.var 1 is a I from Label0 to Label1
.var 2 is c I from Label0 to Label1
.var 3 is f I from Label0 to Label1
Label0:
	iload_1
	iload_2
	iadd
	iload_3
	isub
	ireturn
Label1:
.limit stack 2
.limit locals 4
.end method

.method public add()I
.var 0 is this LShape; from Label0 to Label1
Label0:
	aload_0
	iconst_1
	iconst_2
	iconst_3
	invokevirtual Shape/b(III)I
	ireturn
Label1:
.limit stack 4
.limit locals 1
.end method

.method public <init>()V
.var 0 is this LShape; from Label0 to Label1
Label0:
	aload_0
	invokespecial java/lang/Object/<init>()V
Label1:
	return
.limit stack 1
.limit locals 1
.end method
