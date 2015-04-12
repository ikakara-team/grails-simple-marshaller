grails.project.work.dir = 'target'
grails.project.target.level = 1.7
grails.project.source.level = 1.7

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
    build(':tomcat:8.0.21') {
      export = false
    }

    compile ':plugin-config:0.2.0'

    build(':release:3.1.1', ':rest-client-builder:2.1.1') {
      export = false
    }
  }
}
