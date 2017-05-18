.source TAPPLClass.java
.class public TAPPLClass
.super java.lang.Object

.method public static main([Ljava/lang/String;)V
.var 0 is args [Ljava/lang/String; from Label0 to Label1
.var 1 is b F from Label0 to Label1
Label0:
	ldc 5.4
	fstore_1
	fload_1
	bipush 6
	i2f
	fcmpl
	ifge Label2
	iconst_1
	goto Label3
Label2:
	iconst_0
Label3:
	ifeq Label4
	fload_1
	iconst_4
	i2f
	fadd
	fstore_1
	goto Label5
Label4:
	fload_1
	iconst_2
	i2f
	fsub
	fstore_1
Label5:
	fload_1
	invokestatic io/writeFloat(F)V
Label1:
	return
.limit stack 3
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
