.source TAPPLClass.java
.class public TAPPLClass
.super java.lang.Object
.field n I
.field b F
.field c F
.field static final d I = 2

.method public static main([Ljava/lang/String;)V
.var 0 is args [Ljava/lang/String; from Label0 to Label1
Label0:
	getstatic TAPPLClass.d I
	invokestatic io/writeIntLn(I)V
Label1:
	return
.limit stack 2
.limit locals 1
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
