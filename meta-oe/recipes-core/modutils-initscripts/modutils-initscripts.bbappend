
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://0001-ignore_modversions.patch \
            file://sh4_initscripts.patch \
           "
INITSCRIPT_NAME = "modutils.sh"
INITSCRIPT_PARAMS = "start 04 S ."
