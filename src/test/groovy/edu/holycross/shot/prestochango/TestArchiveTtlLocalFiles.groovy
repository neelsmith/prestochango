package edu.holycross.shot.prestochango

import edu.harvard.chs.cite.Cite2Urn

import static org.junit.Assert.*
import org.junit.Test




/** Class testing prestochange CiteCollection class.
*/
class TestArchiveTtlLocalFiles extends GroovyTestCase {


  String schemaFileName = "schemas/CiteCollectionInventory.rng"


  @Test void testSingle() {
    File baseDir = new File("testdata")
    if (! baseDir.exists()) {
      baseDir.mkdir()
    }


    String inventoryName = "testdata/signs-collection.xml"
    File inv = new File(inventoryName)
    CollectionArchive cca = new CollectionArchive(inv, schemaFileName, baseDir)

    String urnKey = "urn:cite2:hmt:critsigns.v1:"
    Cite2Urn urn = new Cite2Urn(urnKey)

    def srcList = cca.getDataSources()
    LocalFileSource lfs = srcList[urnKey]
    CiteCollection cc = cca.getCollection(urn)


    def ttl = cca.turtleizeDataArray(lfs.getRecordArray(), cc)
    println "Resulting tt:\n" + ttl

  }


}
