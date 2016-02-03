package com.example.arivald.player.core.di.activity;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Per-activity scope annotation.
 *
 * Created by Arivald on 2016-02-01.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {}
