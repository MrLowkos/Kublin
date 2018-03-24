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

package com.mrlowkos.kublin.utils

import org.apache.logging.log4j.Level
import org.apache.logging.log4j.LogManager

internal object Log {

  private val LOG = LogManager.getLogger(Refs.ID)

  internal inline val level: Level
    get() = LOG.level

  internal fun debug(message: String) {
    LOG.debug(tag(message))
  }

  internal fun debug(message: Any) {
    LOG.debug(tag(message.toString()))
  }

  internal fun debug(message: String, throwable: Throwable) {
    LOG.debug(tag(message), throwable)
  }

  internal fun info(message: String) {
    LOG.info(tag(message))
  }

  internal fun info(message: Any) {
    LOG.info(tag(message.toString()))
  }

  internal fun info(message: String, throwable: Throwable) {
    LOG.info(tag(message), throwable)
  }

  internal fun warn(message: String) {
    LOG.warn(tag(message))
  }

  internal fun warn(message: Any) {
    LOG.warn(tag(message.toString()))
  }

  internal fun warn(message: String, throwable: Throwable) {
    LOG.warn(tag(message), throwable)
  }

  internal fun error(message: String) {
    LOG.error(tag(message))
  }

  internal fun error(message: Any) {
    LOG.error(tag(message.toString()))
  }

  internal fun error(message: String, throwable: Throwable) {
    LOG.error(tag(message), throwable)
  }

  internal fun fatal(message: String) {
    LOG.fatal(tag(message))
  }

  internal fun fatal(message: Any) {
    LOG.fatal(tag(message.toString()))
  }

  internal fun fatal(message: String, throwable: Throwable) {
    LOG.fatal(tag(message), throwable)
  }

  internal fun trace(message: String) {
    LOG.trace(tag(message))
  }

  internal fun trace(message: Any) {
    LOG.trace(tag(message.toString()))
  }

  internal fun trace(message: String, throwable: Throwable) {
    LOG.trace(tag(message), throwable)
  }

  private fun tag(message: String): String {
    return "${Refs.MOD_LOG_TAG} $message"
  }
}
