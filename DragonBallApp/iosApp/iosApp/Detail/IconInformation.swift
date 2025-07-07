//
//  IconInformation.swift
//  iosApp
//
//  Created by David FIGUERES FORTUNA on 7/7/25.
//

import SwiftUI

struct IconInformation: View {
    let text:String
    let Icon:Image
    
    var body: some View {
        VStack{
            Icon.resizable()
                .frame(width: 50, height: 50)
            Text(text)
        }
    }
}


