/* Generated By:JJTree: Do not edit this line. OInPathItemOpt.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=O,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.orientechnologies.orient.core.sql.parser;

public class OInPathItemOpt extends OInPathItem {
  public OInPathItemOpt(int id) {
    super(id);
  }

  public OInPathItemOpt(OrientSql p, int id) {
    super(p, id);
  }

  /** Accept the visitor. **/
  public Object jjtAccept(OrientSqlVisitor visitor, Object data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=ef282589054869578c47f554474b5c3b (do not edit this line) */
