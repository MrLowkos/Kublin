/*#################################################################################################
 # Copyright (c) 2018.  MrLowkos - Quentin D.                                                     #
 #                                                                                                #
 # Permission is hereby granted, free of charge, to any person obtaining a copy                   #
 # of this software and associated documentation files (the "Software"), to deal                  #
 # in the Software without restriction,including without limitation the rights                    #
 # to use, copy, modify, merge, publish, distribute, sublicense, and/or sell                      #
 # copies of the Software, and to permit persons to whom the Software is                          #
 # furnished to do so, subject to the following conditions:                                       #
 #                                                                                                #
 # The above copyright notice and this permission notice shall be included in all                 #
 # copies or substantial portions of the Software.                                                #
 #                                                                                                #
 # THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR                     #
 # IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,                       #
 # FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE                    #
 # AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER                         #
 # LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,                  #
 # OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE                  #
 # SOFTWARE.                                                                                      #
 #################################################################################################*/

package com.mrlowkos.kublin.adapter

import com.mrlowkos.kublin.utils.Log
import net.minecraftforge.fml.common.FMLModContainer
import net.minecraftforge.fml.common.ILanguageAdapter
import net.minecraftforge.fml.common.ModContainer
import net.minecraftforge.fml.relauncher.Side

import java.lang.reflect.Field
import java.lang.reflect.Method

/**
 * @author MrLowkos
 * @version 1.0.0
 * @since 1.0.0
 */
class KotlinAdapter : ILanguageAdapter {

  @Throws(IllegalAccessException::class,
      IllegalArgumentException::class,
      NullPointerException::class,
      ExceptionInInitializerError::class)
  override fun setProxy(target: Field, proxyTarget: Class<*>, proxy: Any) {

    Log.debug("Setting proxy: ${target.declaringClass.simpleName}.${target.name} -> $proxy")

    target.set(proxyTarget.kotlin.objectInstance, proxy)
  }

  @Throws(IllegalAccessException::class,
      InstantiationException::class)
  override fun getNewInstance(container: FMLModContainer,
                              kotlinObjectClass: Class<*>,
                              classLoader: ClassLoader,
                              factoryMarkedAnnotation: Method?): Any {

    Log.debug("FML has asked for ${kotlinObjectClass.simpleName} to be constructed")

    return when {
      factoryMarkedAnnotation != null -> factoryMarkedAnnotation(null)
      "INSTANCE" in kotlinObjectClass.fields.map { it.name } -> kotlinObjectClass.getField("INSTANCE").get(null)
      else -> kotlinObjectClass.newInstance()
    }
  }

  override fun supportsStatics() = false

  override fun setInternalProxies(mod: ModContainer, side: Side, loader: ClassLoader) = Unit

}