/**
 * MIT License
 *
 * Copyright (c) 2017 Quavo
 * Copyright (c) 2017 Jordan Abraham
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.quavo.osrs.network.handler.listener;

import com.quavo.Quavo;
import com.quavo.osrs.network.handler.NetworkMessageListener;
import com.quavo.osrs.network.handler.inbound.LoginRequest;
import com.quavo.osrs.network.handler.outbound.LoginResponse;
import com.quavo.osrs.network.protocol.ClientMessage;

import io.netty.channel.ChannelHandlerContext;

/**
 * @author _jordan <citellumrsps@gmail.com>
 */
public final class LoginListener implements NetworkMessageListener<LoginRequest> {

	@Override
	public void handleMessage(ChannelHandlerContext ctx, LoginRequest msg) {
		ClientMessage message = ClientMessage.SUCCESSFUL;
		if (msg.getVersion() != Quavo.VERSION) {
			message = ClientMessage.OUT_OF_DATE;
		}

		ctx.write(new LoginResponse(message, msg.getType()));
	}

}
