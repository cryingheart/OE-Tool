DESCRIPTION = "serviceapp service for enigma2"
AUTHOR = "Maroš Ondrášek <mx3ldev@gmail.com>"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS = "enigma2 uchardet openssl"
RDEPENDS_${PN} = "enigma2 uchardet exteplayer3 openssl python-json"

SRCREV = "${AUTOREV}"
SRC_URI = \
	"git://github.com/mx3L/serviceapp.git;branch=master \
	file://0001-serviceapp-add-setQpipMode-function-recently-added-f.patch \
	"

S = "${WORKDIR}/git"

inherit autotools gitpkgv pythonnative pkgconfig gettext

CXXFLAGS_append = " -std=gnu++11"

PV = "1+git${SRCPV}"
PKGV = "1+git${GITPKGV}"

PR = "r4"

EXTRA_OECONF = "\
	BUILD_SYS=${BUILD_SYS} \
	HOST_SYS=${HOST_SYS} \
	STAGING_INCDIR=${STAGING_INCDIR} \
	STAGING_LIBDIR=${STAGING_LIBDIR} \
	"


FILES_${PN} = "\
	${libdir}/enigma2/python/Plugins/SystemPlugins/ServiceApp/*.pyo \
	${libdir}/enigma2/python/Plugins/SystemPlugins/ServiceApp/locale/*/LC_MESSAGES/ServiceApp.mo \
	${libdir}/enigma2/python/Plugins/SystemPlugins/ServiceApp/serviceapp.so"

FILES_${PN}-dev = "\
	${libdir}/enigma2/python/Plugins/SystemPlugins/ServiceApp/*.py \
${libdir}/enigma2/python/Plugins/SystemPlugins/ServiceApp/serviceapp.la"
