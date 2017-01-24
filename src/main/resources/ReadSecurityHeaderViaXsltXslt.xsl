<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/"
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">

    <xsl:template match="/">
    <xsl:variable name = "User">
        <xsl:value-of select="/*[local-name()='Envelope']/*[local-name()='Header']/*[local-name()='UsernameToken']/*[local-name()='Username']/text()"/>
    </xsl:variable>

    User name : <xsl:value-of select="$User"/>
    </xsl:template>
</xsl:stylesheet>