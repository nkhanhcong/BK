.source TAPPLClass.java
.class public TAPPLClass
.super java.lang.Object
.field a I
.field c F
.field b F
.field static final d Ljava/lang/String; = "test1"

.method public static main([Ljava/lang/String;)V
.var 0 is args [Ljava/lang/String; from Label0 to Label1
.var 1 is abc I from Label0 to Label1
Label0:
	iconst_1
	istore_1
	iload_1
	invokestatic io/writeIntLn(I)V
Label1:
	return
.limit stack 1
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
