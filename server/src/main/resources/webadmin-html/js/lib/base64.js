/*
 * Copyright (c) 2002-2011 "Neo Technology,"
 * Network Engine for Objects in Lund AB [http://neotechnology.com]
 *
 * This file is part of Neo4j.
 *
 * Neo4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
var Base64={_keyStr:"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=",encode:function(b){var d="",c,a,f,g,h,e,i=0;for(b=Base64._utf8_encode(b);i<b.length;){c=b.charCodeAt(i++);a=b.charCodeAt(i++);f=b.charCodeAt(i++);g=c>>2;c=(c&3)<<4|a>>4;h=(a&15)<<2|f>>6;e=f&63;if(isNaN(a))h=e=64;else if(isNaN(f))e=64;d=d+this._keyStr.charAt(g)+this._keyStr.charAt(c)+this._keyStr.charAt(h)+this._keyStr.charAt(e)}return d},decode:function(b){var d="",c,a,f,g,h,e=0;for(b=b.replace(/[^A-Za-z0-9\+\/\=]/g, "");e<b.length;){c=this._keyStr.indexOf(b.charAt(e++));a=this._keyStr.indexOf(b.charAt(e++));g=this._keyStr.indexOf(b.charAt(e++));h=this._keyStr.indexOf(b.charAt(e++));c=c<<2|a>>4;a=(a&15)<<4|g>>2;f=(g&3)<<6|h;d+=String.fromCharCode(c);if(g!=64)d+=String.fromCharCode(a);if(h!=64)d+=String.fromCharCode(f)}return d=Base64._utf8_decode(d)},_utf8_encode:function(b){b=b.replace(/\r\n/g,"\n");for(var d="",c=0;c<b.length;c++){var a=b.charCodeAt(c);if(a<128)d+=String.fromCharCode(a);else{if(a>127&&a<2048)d+= String.fromCharCode(a>>6|192);else{d+=String.fromCharCode(a>>12|224);d+=String.fromCharCode(a>>6&63|128)}d+=String.fromCharCode(a&63|128)}}return d},_utf8_decode:function(b){for(var d="",c=0,a=c1=c2=0;c<b.length;){a=b.charCodeAt(c);if(a<128){d+=String.fromCharCode(a);c++}else if(a>191&&a<224){c2=b.charCodeAt(c+1);d+=String.fromCharCode((a&31)<<6|c2&63);c+=2}else{c2=b.charCodeAt(c+1);c3=b.charCodeAt(c+2);d+=String.fromCharCode((a&15)<<12|(c2&63)<<6|c3&63);c+=3}}return d}};