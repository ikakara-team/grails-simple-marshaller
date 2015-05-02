/* Copyright 2014-2015 Allen Arakaki.  All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ikakara.simplemarshaller.web.app

import grails.converters.JSON
import grails.converters.XML
import ikakara.simplemarshaller.annotation.SimpleMarshaller
import ikakara.simplemarshaller.util.CollectionUtil

class SimpleMarshallerService {

  static transactional = false

  void register(Class clazz) {
    log.debug ("Register ${clazz}")

    SimpleMarshaller sm =  clazz.getAnnotation(SimpleMarshaller)
    if (!sm) {
      return
    }

    log.info ("... registering ${clazz}")

    Set properties = CollectionUtil.buildHashSet(sm.includes())

    def converter = {
      // filter the key-value pairs to output:
      return it.properties.findAll { k,v -> properties.contains(k) }
    }

    JSON.registerObjectMarshaller(clazz, converter)
    XML.registerObjectMarshaller(clazz, converter)
  }
}
