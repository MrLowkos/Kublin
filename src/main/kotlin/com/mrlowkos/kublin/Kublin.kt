package com.mrlowkos.kublin

import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import org.apache.logging.log4j.LogManager

/**
 * @author MrLowkos
 */
@Mod(name = Refs.NAME,
    modid = Refs.ID,
    version = Refs.VERSION,
    acceptedMinecraftVersions = Refs.ACCEPTED,
    acceptableRemoteVersions =  Refs.ACCEPTED,
    modLanguage = Refs.LANGUAGE,
    modLanguageAdapter = Refs.ADAPTER)
object Kublin {

  private var log = LogManager.getLogger(Kublin)

  @EventHandler
  fun preInit(event: FMLPreInitializationEvent) {
    log.info("${Refs.MOD_LOG_TAG} Kotlin in da'place !")
  }

}