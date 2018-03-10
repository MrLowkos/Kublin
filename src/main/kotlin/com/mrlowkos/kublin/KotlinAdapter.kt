package com.mrlowkos.kublin

import net.minecraftforge.fml.common.FMLModContainer
import net.minecraftforge.fml.common.ILanguageAdapter
import net.minecraftforge.fml.common.ModContainer
import net.minecraftforge.fml.relauncher.Side

import org.apache.logging.log4j.LogManager

import java.lang.reflect.Field
import java.lang.reflect.Method

/**
 * @author MrLowkos
 */
class KotlinAdapter : ILanguageAdapter {

  companion object {

    private val log = LogManager.getLogger(KotlinAdapter)

  }

  @Throws(IllegalArgumentException::class,
      IllegalAccessException::class,
      NoSuchFieldException::class,
      SecurityException::class)
  override fun setProxy(target: Field, proxyTarget: Class<*>, proxy: Any) {

    log.info("${Refs.ADAPTER_LOG_TAG} Setting proxy: ${target.declaringClass.simpleName}.${target.name} -> $proxy")

    target.set(proxyTarget, proxy)
  }

  @Throws(Exception::class)
  override fun getNewInstance(container: FMLModContainer,
                              kotlinObjectClass: Class<*>,
                              classLoader: ClassLoader,
                              factoryMarkedAnnotation: Method?): Any {

    log.info("${Refs.ADAPTER_LOG_TAG} FML has asked for ${kotlinObjectClass.simpleName} to be constructed")

    return when {
      factoryMarkedAnnotation != null -> factoryMarkedAnnotation.invoke(null)
      else -> kotlinObjectClass.kotlin.objectInstance ?: kotlinObjectClass.newInstance()
    }
  }

  override fun supportsStatics() = false

  override fun setInternalProxies(mod: ModContainer, side: Side, loader: ClassLoader) = Unit

}