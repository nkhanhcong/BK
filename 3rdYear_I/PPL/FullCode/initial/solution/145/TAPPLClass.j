.source TAPPLClass.java
.class public TAPPLClass
.super java.lang.Object
.field n F
.field b F
.field arr [I

.method public static main([Ljava/lang/String;)V
.var 0 is args [Ljava/lang/String; from Label0 to Label1
.var 1 is x I from Label0 to Label1
Label0:
	invokestatic io/readInt()I
	istore_1
	iconst_1
	iconst_5
	iadd
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
	aload_0
	iconst_5
	newarray int
	putfield TAPPLClass.arr [I
Label1:
	return
.limit stack 2
.limit locals 1
.end method
