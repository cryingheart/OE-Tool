DESCRIPTION = "OpenGL ES v1.0 library and headers"

HOMEPAGE = "https://github/Duckbox-Developers/apps"
SECTION = "base"
require conf/license/license-gplv2.inc
DEPENDS = "fulan-dvb-modules-${MACHINE} directfb"

inherit autotools gitpkgv

SRCREV = "${AUTOREV}"
PV = "1.0+git${SRCPV}"
PKGV = "1.0+git${GITPKGV}"

SRC_URI = " \
    git://github.com/Duckbox-Developers/apps.git;protocol=git \
"
S = "${WORKDIR}/git/libs/${@d.getVar('PN',1).replace('-', '_')}"

EXTRA_OECONF = "--enable-silent-rules --prefix="
LDFLAGS += "-lpthread -lrt"

do_configure_prepend() {
    touch ${S}/NEWS
    touch ${S}/README
    touch ${S}/AUTHORS
    touch ${S}/COPYING
    touch ${S}/ChangeLog
}

CFLAGS_append = " -I${STAGING_INCDIR}/directfb"

PROVIDES = "virtual/libgles1 virtual/egl"

INSANE_SKIP_${PN} += "dev-so"
