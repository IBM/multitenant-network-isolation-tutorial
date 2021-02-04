/*******************************************************************************
Copyright (c) 2020 IBM Corporation and others

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*******************************************************************************/
package com.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

@Path("/getdata")
public class GetData {

	@GET
	public String getRequest() {
		URL url;
		StringBuffer content = new StringBuffer();
		try {
			url = new URL("http://app2.project2.svc.cluster.local:9080/app2/resource");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.connect();
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			in.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return content.toString();
	}
}
