.source a.java
.class public a
.super java.lang.Object
.field final b Ljava/lang/String; = "hello"

.method public <init>()V
.var 0 is this La; from Label0 to Label1
Label0:
	aload_0
	invokespecial java/lang/Object/<init>()V
	aload_0
	ldc "hello"
	putfield a.b Ljava/lang/String;
Label1:
	return
.limit stack 2
.limit locals 1
.end method
