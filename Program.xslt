<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:msxsl="urn:schemas-microsoft-com:xslt" exclude-result-prefixes="msxsl"
>
    <xsl:output method="html" indent="yes"/>

    <xsl:template match="/">
      <html>
        <body>
          <xsl:for-each select="TvProgram/Channels/Channel">
            <h1><xsl:value-of select="@Name"/></h1>
              <xsl:for-each select="Days/Day">
                <h2>
                  <xsl:value-of select="@day"/>
                </h2>
                <xsl:for-each select="Shows/Show">
                  <table width="100%">
                    <tr>
                      <td width="10%">
                        <xsl:value-of select="@StartsAt"/>
                      </td>
                      <td width="20%">
                        <xsl:value-of select="@Title"/>
                      </td>
                      <td width="60%">
                        <xsl:value-of select="@Format"/>
                      </td>
                    </tr>
                  </table>                  
                </xsl:for-each>
              </xsl:for-each>
          </xsl:for-each>
        </body>
      </html>
    </xsl:template>
</xsl:stylesheet>
