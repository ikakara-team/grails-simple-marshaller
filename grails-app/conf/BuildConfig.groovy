grails.project.work.dir = 'target'

grails.project.dependency.resolver = 'maven'
grails.project.dependency.resolution = {
  inherits 'global'
  log 'warn'

  repositories {
    mavenLocal()
    grailsCentral()
    mavenCentral()
  }

  plugins {
    build(':tomcat:8.0.20') {
      export = false
    }

    compile ':plugin-config:0.2.0'

    build(':release:3.0.1', ':rest-client-builder:2.0.3') {
      export = false
    }
  }
}
