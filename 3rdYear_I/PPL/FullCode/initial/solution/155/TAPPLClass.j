.source TAPPLClass.java
.class public TAPPLClass
.super java.lang.Object

.method public static main([Ljava/lang/String;)V
.var 0 is args [Ljava/lang/String; from Label0 to Label1
.var 1 is i LB; from Label0 to Label1
Label0:
	new B
	dup
	invokespecial B/<init>()V
	astore_1
	iconst_1
	iconst_2
	invokestatic B/sum(II)I
	iconst_3
	if_icmpne Label2
	iconst_1
	goto Label3
Label2:
	iconst_0
Label3:
	ifeq Label4
	iconst_1
	invokestatic io/writeInt(I)V
	goto Label5
Label4:
	iconst_2
	invokestatic io/writeInt(I)V
Label5:
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
