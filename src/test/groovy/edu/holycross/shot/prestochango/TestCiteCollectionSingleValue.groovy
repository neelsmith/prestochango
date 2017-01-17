package edu.holycross.shot.prestochango

import edu.harvard.chs.cite.Cite2Urn

import static org.junit.Assert.*
import org.junit.Test




/** Class testing output of ttl from prestochango's CollectionArchive class.
*/
class TestCiteCollectionSingleValue extends GroovyTestCase {



 @Test void testGetPropNames() {
   def vocabList = ["recto", "verso"] as Set
   CiteProperty pageSide = new CiteProperty("rv","Recto or verso side",vocabList)

	Cite2Urn collUrn = new Cite2Urn("urn:cite2:testNs:testColl.v1:")
  String descr = "Test collection"
	CiteProperty idProp = new CiteProperty("urn",CitePropertyType.CITE2_URN,"canonical id")
	CiteProperty labelProp = new CiteProperty("label",CitePropertyType.STRING,"description of object")

  CiteProperty msA = new CiteProperty("ms",CitePropertyType.CITE2_URN,"Codex")
  // Set universal value on property before adding to collection:
  msA.setSingleValue("urn:cite2:hmt:msA.v1:")

	ArrayList collProps = [idProp, labelProp, pageSide, msA]



	String nsAbbr = "testNs"
	String nsFull = "http://www.testNs.org/datans"

  CiteCollection cc = new CiteCollection(collUrn, descr, idProp, labelProp, null, nsAbbr, nsFull, collProps, null)

  Cite2Urn actualUrn = cc.getSingleValue("ms") as Cite2Urn
  assert actualUrn.toString() == "urn:cite2:hmt:msA.v1:"


  def msg = shouldFail {
    def uval = cc.getSingleValue("urn")
  }
  assert msg == "CiteProperty: single value not defined for property urn"
 }




}
