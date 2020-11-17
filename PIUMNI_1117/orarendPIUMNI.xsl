<?xml version = "1.0" encoding = "UTF-8"?>  

<xsl:stylesheet version = "1.0"   
xmlns:xsl = "http://www.w3.org/1999/XSL/Transform">     

   <xsl:template match = "/orarendNEPTUNKOD.xml">   
     
      <html>   
         <body>  
            <h2>Orarend</h2>   
            <table border = "1">   
               <tr bgcolor = "#9acd32">   
                  <th>Oktató</th>   
                  <th>Helyszin</th>   
                  <th>Szak</th>   
                  <th>Tárgy</th>   
                  <th>Fizetes</th>   
               </tr>   
              
              <xsl:for-each select="orarend/ora">   
                  <tr>   
                     <td>   
                        <xsl:value-of select = "@id"/>   
                     </td>   
                     <td><xsl:value-of select = "oktato"/></td>   
                     <td><xsl:value-of select = "helyszin"/></td>   
                     <td><xsl:value-of select = "szak"/></td>   
                     <td><xsl:value-of select = "targy"/></td>     
                  </tr>   
               </xsl:for-each>   
            </table>   
         </body>   
      </html>   
   </xsl:template>    
</xsl:stylesheet>  