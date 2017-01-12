SUMMARY = "Base packages require for image."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

ALLOW_EMPTY_${PN} = "1"

PV = "1.0"
PR = "r27"

inherit packagegroup

RDEPENDS_${PN} = "\
    oe-alliance-base \
    openhdf-enigma2 \
    openhdf-bootlogo \
    openhdf-spinner \
    openssh-sftp-server \
    ntfs-3g \
    curl \
    hddtemp \
    busybox-cron \
    python-gdata \
    python-requests \
    unrar \
    ofgwrite \
    packagegroup-base-smbfs-client \
    rtmpdump \
    ${@bb.utils.contains("MACHINE_FEATURES", "smallflash", "", \
    " \
    enigma2-plugin-extensions-openwebif-themes \
    enigma2-plugin-extensions-openwebif-webtv \
    enigma2-plugin-extensions-openwebif-vxg \
    exteplayer3 \
    gstplayer \
    ffmpeg \
    zip \
    ", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "dreambox", "", "ofgwrite", d)} \
    ${@bb.utils.contains("TUNE_FEATURES", "armv7a", "glibc-compat", "", d)} \
    libungif \
    "
