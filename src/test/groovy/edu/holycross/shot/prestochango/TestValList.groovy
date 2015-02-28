package edu.holycross.shot.prestochango

import edu.harvard.chs.cite.CiteUrn

import static org.junit.Assert.*
import org.junit.Test



/** Class testing output of ttl from prestochango's CollectionArchive class.
*/
class TestValList extends GroovyTestCase {

  String schemaFileName = "schemas/CiteCollectionInventory.rng"

    CiteUrn coll = new CiteUrn("urn:cite:hmt:msA")
    File tsvInv = new File( "testdata/hmtcollections.xml")
    File tsvDir = new File("testdata/hmtdata")

    @Test void testOrder() {
        CollectionArchive cc = new CollectionArchive(tsvInv, schemaFileName, tsvDir)
	cc.debug = 8

        String valProp = "RV"
        def expectedValues = ["recto","verso"]

        assert cc.getValueList(coll,valProp).sort() == expectedValues
                               
    }



}