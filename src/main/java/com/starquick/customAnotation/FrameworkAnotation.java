package com.starquick.customAnotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.starquick.enums.CatogoryType;

@Retention(RUNTIME)
@Target(METHOD)
public @interface FrameworkAnotation {
	public String[] author();
	public CatogoryType[] category();
	

}
