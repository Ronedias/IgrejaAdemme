package br.com.ademme.util;

import java.lang.annotation.ElementType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.interceptor.InterceptorBinding;


/*interface que contem as anotaçoẽs responsaveis
 *  por abrir uma transação por rouback e comit*/


/*anotação vai funcionar pra metodos e pra TYPE*/
@Target({ElementType.METHOD,ElementType.TYPE})

@Retention(RetentionPolicy.RUNTIME)
@InterceptorBinding
public @interface Transacional {

}
