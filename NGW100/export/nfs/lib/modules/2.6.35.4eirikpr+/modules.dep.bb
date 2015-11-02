kernel/drivers/usb/gadget/g_zero.ko

kernel/drivers/usb/gadget/g_cdc.ko

kernel/drivers/usb/gadget/g_ether.ko

kernel/drivers/usb/gadget/g_file_storage.ko

kernel/drivers/usb/gadget/gadgetfs.ko

kernel/drivers/usb/gadget/g_serial.ko

kernel/drivers/block/brd.ko rd block_major_1_*

kernel/drivers/block/nbd.ko

kernel/drivers/block/loop.ko block_major_7_* symbol:loop_unregister_transfer symbol:loop_register_transfer

kernel/drivers/mmc/host/mmc_spi.ko spi:mmc_spi
crc_itu_t crc7

kernel/drivers/mmc/card/mmc_test.ko

kernel/drivers/misc/eeprom/at24.ko i2c:at24 i2c:24c1024 i2c:24c512 i2c:24c256 i2c:24c128 i2c:24c64 i2c:24c32 i2c:24c16 i2c:24c08 i2c:24c04 i2c:spd i2c:24c02 i2c:24c01 i2c:24c00
i2c_core

kernel/drivers/net/pppoe.ko net_pf_24
pppox ppp_generic

kernel/drivers/net/tun.ko devname:net/tun char_major_10_200 symbol:tun_get_socket

kernel/drivers/net/pppox.ko symbol:pppox_ioctl symbol:pppox_unbind_sock symbol:unregister_pppox_proto symbol:register_pppox_proto
ppp_generic

kernel/drivers/net/ppp_async.ko tty_ldisc_3
ppp_generic crc_ccitt

kernel/drivers/net/ppp_mppe.ko ppp_compress_18
ppp_generic

kernel/drivers/net/ppp_deflate.ko ppp_compress_24 ppp_compress_26
ppp_generic

kernel/drivers/net/slhc.ko symbol:slhc_toss symbol:slhc_uncompress symbol:slhc_compress symbol:slhc_remember symbol:slhc_free symbol:slhc_init

kernel/drivers/net/ppp_generic.ko devname:ppp char_major_108_0 symbol:ppp_unregister_compressor symbol:ppp_register_compressor symbol:ppp_output_wakeup symbol:ppp_input_error symbol:ppp_input symbol:ppp_dev_name symbol:ppp_unit_number symbol:ppp_channel_index symbol:ppp_unregister_channel symbol:ppp_register_channel symbol:ppp_register_net_channel
slhc

kernel/drivers/net/bsd_comp.ko ppp_compress_21
ppp_generic

kernel/drivers/i2c/algos/i2c-algo-bit.ko symbol:i2c_bit_add_numbered_bus symbol:i2c_bit_add_bus
i2c_core

kernel/drivers/i2c/i2c-dev.ko
i2c_core

kernel/drivers/i2c/i2c-core.ko symbol:i2c_smbus_xfer symbol:i2c_smbus_write_i2c_block_data symbol:i2c_smbus_read_i2c_block_data symbol:i2c_smbus_write_block_data symbol:i2c_smbus_read_block_data symbol:i2c_smbus_process_call symbol:i2c_smbus_write_word_data symbol:i2c_smbus_read_word_data symbol:i2c_smbus_write_byte_data symbol:i2c_smbus_read_byte_data symbol:i2c_smbus_write_byte symbol:i2c_smbus_read_byte symbol:i2c_put_adapter symbol:i2c_get_adapter symbol:i2c_master_recv symbol:i2c_master_send symbol:i2c_transfer symbol:i2c_clients_command symbol:i2c_release_client symbol:i2c_use_client symbol:i2c_del_driver symbol:i2c_register_driver symbol:i2c_del_adapter symbol:i2c_add_adapter symbol:i2c_verify_client symbol:i2c_new_probed_device symbol:i2c_add_numbered_adapter symbol:i2c_new_dummy symbol:i2c_unregister_device symbol:i2c_new_device symbol:i2c_bus_type

kernel/drivers/i2c/busses/i2c-gpio.ko platform:i2c_gpio
i2c_algo_bit i2c_core

kernel/drivers/spi/spidev.ko spi:spidev

kernel/crypto/aes_generic.ko aes symbol:crypto_aes_set_key symbol:crypto_aes_expand_key symbol:crypto_il_tab symbol:crypto_it_tab symbol:crypto_fl_tab symbol:crypto_ft_tab

kernel/crypto/ansi_cprng.ko stdrng

kernel/crypto/pcbc.ko

kernel/crypto/ecb.ko

kernel/crypto/arc4.ko

kernel/fs/exportfs/exportfs.ko symbol:exportfs_decode_fh symbol:exportfs_encode_fh

kernel/fs/cifs/cifs.ko
nls_base

kernel/fs/fuse/fuse.ko devname:fuse char_major_10_229 symbol:fuse_dev_operations symbol:fuse_dev_release symbol:fuse_abort_conn symbol:fuse_request_send_background symbol:fuse_request_send symbol:fuse_put_request symbol:fuse_get_req symbol:fuse_request_alloc symbol:fuse_file_poll symbol:fuse_do_ioctl symbol:fuse_direct_io symbol:fuse_sync_release symbol:fuse_do_open symbol:fuse_conn_get symbol:fuse_conn_put symbol:fuse_conn_init symbol:fuse_conn_kill

kernel/fs/fat/fat.ko symbol:fat_add_entries symbol:fat_alloc_new_dir symbol:fat_remove_entries symbol:fat_scan symbol:fat_dir_empty symbol:fat_get_dotdot_entry symbol:fat_search_long symbol:fat_free_clusters symbol:fat_setattr symbol:fat_getattr symbol:fat_flush_inodes symbol:fat_fill_super symbol:fat_sync_inode symbol:fat_build_inode symbol:fat_detach symbol:fat_attach symbol:fat_time_unix2fat symbol:__fat_fs_error
nls_base

kernel/fs/fat/vfat.ko
fat nls_base

kernel/fs/fat/msdos.ko
fat

kernel/fs/nfsd/nfsd.ko
exportfs

kernel/fs/configfs/configfs.ko symbol:configfs_unregister_subsystem symbol:configfs_register_subsystem symbol:configfs_undepend_item symbol:configfs_depend_item symbol:config_group_find_item symbol:config_item_put symbol:config_item_get symbol:config_group_init symbol:config_item_init symbol:config_group_init_type_name symbol:config_item_init_type_name symbol:config_item_set_name

kernel/fs/nls/nls_iso8859-1.ko
nls_base

kernel/fs/nls/nls_cp850.ko
nls_base

kernel/fs/nls/nls_base.ko symbol:load_nls_default symbol:load_nls symbol:unload_nls symbol:unregister_nls symbol:register_nls symbol:utf16s_to_utf8s symbol:utf8s_to_utf16s symbol:utf32_to_utf8 symbol:utf8_to_utf32

kernel/fs/nls/nls_cp437.ko
nls_base

kernel/fs/nls/nls_utf8.ko
nls_base

kernel/fs/smbfs/smbfs.ko
nls_base

kernel/net/netfilter/nfnetlink.ko net_pf_16_proto_12 symbol:nfnetlink_unicast symbol:nfnetlink_set_err symbol:nfnetlink_send symbol:nfnetlink_has_listeners symbol:nfnetlink_subsys_unregister symbol:nfnetlink_subsys_register symbol:nfnl_unlock symbol:nfnl_lock

kernel/net/netfilter/nf_conntrack_irc.ko nfct_helper_irc ip_conntrack_irc symbol:nf_nat_irc_hook
nf_conntrack

kernel/net/netfilter/nf_conntrack_ftp.ko nfct_helper_ftp ip_conntrack_ftp symbol:nf_nat_ftp_hook
nf_conntrack

kernel/net/netfilter/nf_conntrack_netlink.ko nfnetlink_subsys_2 nfnetlink_subsys_1 ip_conntrack_netlink
nf_conntrack nfnetlink

kernel/net/netfilter/xt_policy.ko ip6t_policy ipt_policy

kernel/net/netfilter/xt_state.ko ip6t_state ipt_state
nf_conntrack

kernel/net/netfilter/nf_conntrack_sip.ko nfct_helper_sip ip_conntrack_sip symbol:ct_sip_get_sdp_header symbol:ct_sip_parse_numerical_param symbol:ct_sip_parse_address_param symbol:ct_sip_parse_header_uri symbol:ct_sip_get_header symbol:ct_sip_parse_request symbol:nf_nat_sdp_media_hook symbol:nf_nat_sdp_session_hook symbol:nf_nat_sdp_port_hook symbol:nf_nat_sdp_addr_hook symbol:nf_nat_sip_expect_hook symbol:nf_nat_sip_seq_adjust_hook symbol:nf_nat_sip_hook
nf_conntrack

kernel/net/netfilter/xt_conntrack.ko ip6t_conntrack ipt_conntrack
nf_conntrack

kernel/net/netfilter/xt_NFLOG.ko ip6t_NFLOG ipt_NFLOG
nfnetlink_log

kernel/net/netfilter/nf_conntrack.ko symbol:nf_ct_nat_offset symbol:nf_conntrack_set_hashsize symbol:nf_ct_alloc_hashtable symbol:nf_conntrack_flush_report symbol:nf_ct_free_hashtable symbol:nf_ct_iterate_cleanup symbol:nf_ct_port_nlattr_tuple_size symbol:nf_ct_port_nlattr_to_tuple symbol:nf_ct_port_nla_policy symbol:nf_ct_port_tuple_to_nlattr symbol:__nf_ct_kill_acct symbol:__nf_ct_refresh_acct symbol:nf_conntrack_alter_reply symbol:nf_ct_invert_tuplepr symbol:nf_conntrack_in symbol:nf_conntrack_free symbol:nf_conntrack_alloc symbol:nf_conntrack_tuple_taken symbol:__nf_conntrack_confirm symbol:nf_conntrack_hash_insert symbol:nf_conntrack_find_get symbol:__nf_conntrack_find symbol:nf_ct_insert_dying_list symbol:nf_ct_delete_from_lists symbol:nf_ct_invert_tuple symbol:nf_ct_get_tuplepr symbol:nf_ct_get_tuple symbol:nf_conntrack_untracked symbol:nf_conntrack_max symbol:nf_conntrack_htable_size symbol:nf_conntrack_lock symbol:nfnetlink_parse_nat_setup_hook symbol:need_conntrack symbol:print_tuple symbol:nf_ct_expect_related_report symbol:nf_ct_expect_put symbol:nf_ct_expect_init symbol:nf_ct_expect_alloc symbol:nf_ct_unexpect_related symbol:nf_ct_remove_expectations symbol:nf_ct_expect_find_get symbol:__nf_ct_expect_find symbol:nf_ct_unlink_expect symbol:nf_ct_expect_hsize symbol:nf_conntrack_helper_unregister symbol:nf_conntrack_helper_register symbol:__nf_ct_try_assign_helper symbol:nf_ct_helper_ext_add symbol:nf_conntrack_helper_try_module_get symbol:__nf_conntrack_helper_find symbol:nf_conntrack_l4proto_unregister symbol:nf_conntrack_l4proto_register symbol:nf_conntrack_l3proto_unregister symbol:nf_conntrack_l3proto_register symbol:nf_ct_l3proto_module_put symbol:nf_ct_l3proto_try_module_get symbol:nf_ct_l3proto_put symbol:nf_ct_l3proto_find_get symbol:__nf_ct_l4proto_find symbol:nf_ct_l3protos symbol:nf_conntrack_l3proto_generic symbol:nf_conntrack_l4proto_tcp6 symbol:nf_conntrack_l4proto_tcp4 symbol:nf_conntrack_l4proto_udp6 symbol:nf_conntrack_l4proto_udp4 symbol:__nf_ct_ext_add symbol:__nf_ct_ext_destroy symbol:nf_ct_extend_unregister symbol:nf_ct_extend_register symbol:seq_print_acct

kernel/net/netfilter/xt_mark.ko ip6t_MARK ipt_MARK ip6t_mark ipt_mark

kernel/net/netfilter/xt_TCPMSS.ko ip6t_TCPMSS ipt_TCPMSS

kernel/net/netfilter/nfnetlink_log.ko nfnetlink_subsys_4 symbol:nfulnl_log_packet
nfnetlink

kernel/net/ipv4/netfilter/iptable_filter.ko
ip_tables

kernel/net/ipv4/netfilter/ipt_LOG.ko

kernel/net/ipv4/netfilter/ipt_REJECT.ko

kernel/net/ipv4/netfilter/iptable_nat.ko ip_nat
ip_tables nf_conntrack_ipv4 nf_nat nf_conntrack

kernel/net/ipv4/netfilter/nf_conntrack_ipv4.ko ip_conntrack nf_conntrack_2 symbol:need_ipv4_conntrack symbol:nf_nat_seq_adjust_hook
nf_conntrack nf_defrag_ipv4

kernel/net/ipv4/netfilter/nf_defrag_ipv4.ko symbol:nf_defrag_ipv4_enable

kernel/net/ipv4/netfilter/nf_nat.ko nf_nat_ipv4 symbol:nf_nat_protocol_unregister symbol:nf_nat_protocol_register symbol:nf_nat_setup_info symbol:nf_nat_used_tuple symbol:nf_nat_icmp_reply_translation symbol:nf_nat_packet symbol:nf_nat_proto_put symbol:nf_nat_proto_find_get symbol:nf_nat_follow_master symbol:nf_nat_mangle_udp_packet symbol:__nf_nat_mangle_tcp_packet symbol:nf_nat_set_seq_adjust symbol:nf_nat_get_offset symbol:nf_nat_proto_range_to_nlattr symbol:nf_nat_proto_nlattr_to_range symbol:nf_nat_proto_unique_tuple symbol:nf_nat_proto_in_range
nf_conntrack nf_conntrack_ipv4

kernel/net/ipv4/netfilter/iptable_mangle.ko
ip_tables

kernel/net/ipv4/netfilter/ip_tables.ko symbol:ipt_do_table symbol:ipt_unregister_table symbol:ipt_register_table symbol:ipt_alloc_initial_table

kernel/net/ipv4/netfilter/ipt_MASQUERADE.ko
nf_nat nf_conntrack

kernel/net/ipv4/netfilter/nf_nat_irc.ko ip_nat_irc
nf_nat nf_conntrack nf_conntrack_irc

kernel/net/ipv4/netfilter/nf_nat_ftp.ko ip_nat_ftp
nf_conntrack nf_nat nf_conntrack_ftp

kernel/net/ipv4/netfilter/nf_nat_sip.ko ip_nat_sip
nf_conntrack nf_nat nf_conntrack_sip

kernel/net/802/p8022.ko symbol:unregister_8022_client symbol:register_8022_client
llc

kernel/net/802/psnap.ko symbol:unregister_snap_client symbol:register_snap_client
llc

kernel/net/802/stp.ko symbol:stp_proto_unregister symbol:stp_proto_register
llc

kernel/net/llc/llc.ko symbol:llc_sap_close symbol:llc_sap_open symbol:llc_sap_find symbol:llc_sap_list_lock symbol:llc_sap_list symbol:llc_set_station_handler symbol:llc_remove_pack symbol:llc_add_pack symbol:llc_build_and_send_ui_pkt symbol:llc_mac_hdr_init

kernel/net/8021q/8021q.ko rtnl_link_vlan

kernel/net/ipv6/netfilter/nf_conntrack_ipv6.ko nf_conntrack_10
nf_conntrack

kernel/net/ipv6/netfilter/ip6t_REJECT.ko

kernel/net/ipv6/netfilter/ip6_tables.ko symbol:ipv6_find_hdr symbol:ip6t_ext_hdr symbol:ip6t_do_table symbol:ip6t_unregister_table symbol:ip6t_register_table symbol:ip6t_alloc_initial_table

kernel/net/ipv6/netfilter/ip6table_mangle.ko
ip6_tables

kernel/net/ipv6/netfilter/ip6t_LOG.ko
ip6_tables

kernel/net/ipv6/netfilter/ip6t_ipv6header.ko
ip6_tables

kernel/net/ipv6/netfilter/ip6table_filter.ko
ip6_tables

kernel/net/bridge/bridge.ko symbol:br_should_route_hook
stp llc

kernel/arch/avr32/oprofile/oprofile.ko

kernel/lib/crc-ccitt.ko symbol:crc_ccitt symbol:crc_ccitt_table

kernel/lib/crc-itu-t.ko symbol:crc_itu_t symbol:crc_itu_t_table

kernel/lib/crc7.ko symbol:crc7 symbol:crc7_syndrome_table

