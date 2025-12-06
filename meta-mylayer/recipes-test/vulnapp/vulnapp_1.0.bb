SUMMARY = "Small intentionally vulnerable C program for testing Cppcheck"
LICENSE = "CLOSED"

SRC_URI = "file://vulnapp.c"
S = "${UNPACKDIR}"

do_compile() {
    ${CC} ${CFLAGS} ${LDFLAGS} vulnapp.c -o vulnapp
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 vulnapp ${D}${bindir}/vulnapp
}
