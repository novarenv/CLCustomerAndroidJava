package com.example.clcustomer.di.scope;

import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;

@Qualifier
@Retention()
@java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
public @interface PerApplication {
}
