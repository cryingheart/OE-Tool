SUMMARY = "MediaPlayer 2 for Enigma2"
HOMEPAGE = "https://github.com/mx3L/mediaplayer2"
AUTHOR = "Maroš Ondrášek <mx3ldev@gmail.com>"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

RDEPENDS_${PN} = "python-xmlrpc python-compression python-codecs python-zlib python-difflib unrar enigma2-plugin-extensions-subssupport"

SRCREV = "${AUTOREV}"
inherit gitpkgv
PV = "0.74+git${SRCPV}"
PKGV = "0.74+git${GITPKGV}"

SRC_URI = "git://github.com/mx3L/mediaplayer2;protocol=git;branch=master"

S = "${WORKDIR}/git"

do_install_append () {
    mkdir -p ${D}/${libdir}/enigma2/python/Plugins/Extensions/MediaPlayer2
    cp -r ${S}/plugin/* ${D}/${libdir}/enigma2/python/Plugins/Extensions/MediaPlayer2/
}

FILES_${PN} = "${libdir}/enigma2/python/Plugins/Extensions/MediaPlayer2"

inherit autotools-brokensep 
