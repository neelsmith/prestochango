package edu.holycross.shot.prestochango

import edu.harvard.chs.cite.CiteUrn

import static org.junit.Assert.*
import org.junit.Test




/** Class testing prestochange CiteCollection class.
*/
class TestSource extends GroovyTestCase {


  String schemaFileName = "schemas/CiteCollectionInventory.rng"



    String testInventory = "testdata/collections.xml"
    File inv = new File(testInventory)
    CiteUrn urn = new CiteUrn("urn:cite:hmt:msA")
    File dir = new File("testdata/csvs")

    @Test void testSource() {/*()
        CollectionArchive cc = new CollectionArchive(inv, schemaFileName, dir)
        def srcInfo = cc.getSourcePair(urn)
        assert srcInfo[0] == 'file'
        assert srcInfo[1] == 'venetusA.tsv' */
    }

}
